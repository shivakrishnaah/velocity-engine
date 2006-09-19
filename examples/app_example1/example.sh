#!/bin/sh

# Copyright 2000-2006 The Apache Software Foundation.
#
# Licensed under the Apache License, Version 2.0 (the "License")
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#     http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.

echo "Running Example with input file 'example.vm'"

_VELCP=.

for i in ../../bin/*.jar
do
    _VELCP=$_VELCP:"$i"
done

for i in ../../build/lib/*.jar
do
    _VELCP=$_VELCP:"$i"
done

# convert the unix path to windows
if [ "$OSTYPE" = "cygwin32" ] || [ "$OSTYPE" = "cygwin" ] ; then
    _VELCP=`cygpath --path --windows "$_VELCP"`
fi

java -cp $_VELCP Example example.vm

