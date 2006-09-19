@echo off

rem Copyright 2000-2006 The Apache Software Foundation.
rem
rem Licensed under the Apache License, Version 2.0 (the "License")
rem you may not use this file except in compliance with the License.
rem You may obtain a copy of the License at
rem
rem     http://www.apache.org/licenses/LICENSE-2.0
rem
rem Unless required by applicable law or agreed to in writing, software
rem distributed under the License is distributed on an "AS IS" BASIS,
rem WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
rem See the License for the specific language governing permissions and
rem limitations under the License.

set VELCP=.

for %%i in (..\..\bin\*.jar) do call appendVELCP %%i
for %%i in (..\..\bin\lib\*.jar) do call appendVELCP %%i

echo Using classpath:  %VELCP%

java -cp %VELCP% Example2

