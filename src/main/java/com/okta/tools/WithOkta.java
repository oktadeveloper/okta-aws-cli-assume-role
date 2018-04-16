package com.okta.tools;

import java.time.Instant;

/*
 * Copyright 2017 Okta
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

public class WithOkta {
    public static void main(String[] args) throws Exception {
        OktaAwsCliAssumeRole.withEnvironment(OktaAwsConfig.loadEnvironment()).run(Instant.now());
        ProcessBuilder awsProcessBuilder = new ProcessBuilder().inheritIO().command(args);
        Process awsSubProcess = awsProcessBuilder.start();
        int exitCode = awsSubProcess.waitFor();
        System.exit(exitCode);
    }
}
