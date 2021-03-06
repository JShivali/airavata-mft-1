/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.airavata.mft.secret.server.backend.sql;

import org.apache.airavata.mft.secret.server.backend.SecretBackend;
import org.apache.airavata.mft.secret.server.backend.sql.entity.SCPSecretEntity;
import org.apache.airavata.mft.secret.server.backend.sql.repository.SecretRepository;
import org.apache.airavata.mft.secret.service.*;
import org.dozer.DozerBeanMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class SQLSecretBackend implements SecretBackend {

    private static final Logger logger = LoggerFactory.getLogger(SQLSecretBackend.class);

    @Autowired
    private SecretRepository secretRepository;

    private DozerBeanMapper mapper = new DozerBeanMapper();

    @Override
    public void init() {
        logger.info("Initializing database secret backend");
    }

    @Override
    public void destroy() {
        logger.info("Destroying database secret backend");
    }

    @Override
    public Optional<SCPSecret> getSCPSecret(SCPSecretGetRequest request) {
        Optional<SCPSecretEntity> secretEty = secretRepository.findBySecretId(request.getSecretId());
        return secretEty.map(scpSecretEntity -> mapper.map(scpSecretEntity, SCPSecret.newBuilder().getClass()).build());
    }

    @Override
    public SCPSecret createSCPSecret(SCPSecretCreateRequest request) {
        SCPSecretEntity savedEntity = secretRepository.save(mapper.map(request, SCPSecretEntity.class));
        return mapper.map(savedEntity, SCPSecret.newBuilder().getClass()).build();
    }

    @Override
    public boolean updateSCPSecret(SCPSecretUpdateRequest request) {
        secretRepository.save(mapper.map(request, SCPSecretEntity.class));
        return true;
    }

    @Override
    public boolean deleteSCPSecret(SCPSecretDeleteRequest request) {
        secretRepository.deleteById(request.getSecretId());
        return true;
    }
}
