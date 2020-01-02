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

package org.apache.airavata.mft.resource.server.backend;

import org.apache.airavata.mft.resource.service.*;
import org.apache.airavata.registry.api.exception.RegistryServiceException;

import java.util.Optional;

public interface ResourceBackend {
    public Optional<SCPStorage> getSCPStorage(SCPStorageGetRequest request) throws Exception;
    public SCPStorage createSCPStorage(SCPStorageCreateRequest request);
    public boolean updateSCPStorage(SCPStorageUpdateRequest request);
    public boolean deleteSCPStorage(SCPStorageDeleteRequest request);

    public Optional<SCPResource> getSCPResource(SCPResourceGetRequest request) throws Exception;
    public SCPResource createSCPResource(SCPResourceCreateRequest request);
    public boolean updateSCPResource(SCPResourceUpdateRequest request);
    public boolean deleteSCPResource(SCPResourceDeleteRequest request);

    public Optional<LocalResource> getLocalResource(LocalResourceGetRequest request);
    public LocalResource createLocalResource(LocalResourceCreateRequest request);
    public boolean updateLocalResource(LocalResourceUpdateRequest request);
    public boolean deleteLocalResource(LocalResourceDeleteRequest request);
}
