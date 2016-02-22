/**
 * Autosleep
 * Copyright (C) 2016 Orange
 * Authors: Benjamin Einaudi   benjamin.einaudi@orange.com
 *          Arnaud Ruffin      arnaud.ruffin@orange.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.cloudfoundry.autosleep.dao.config.data;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.dialect.H2Dialect;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.annotation.PostConstruct;

@Slf4j
@Configuration
@Profile("default")
@EnableJpaRepositories("org.cloudfoundry.autosleep.dao.repositories.jpa")
public class LocalJpaRepositoryConfig extends AbstractJpaRepositoryConfig {

    @Override
    protected String getHibernateDialect() {
        return H2Dialect.class.getName();
    }

    @PostConstruct
    public void logProfile() {
        log.warn("<<<<<<<<<<<  Warning: loading IN MEMORY persistance profile >>>>>>>>>>>>>>>>>>");
    }

}
