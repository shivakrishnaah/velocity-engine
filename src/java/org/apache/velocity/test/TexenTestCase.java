package org.apache.velocity.test;

/*
 * The Apache Software License, Version 1.1
 *
 * Copyright (c) 2001 The Apache Software Foundation.  All rights
 * reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in
 *    the documentation and/or other materials provided with the
 *    distribution.
 *
 * 3. The end-user documentation included with the redistribution, if
 *    any, must include the following acknowlegement:
 *       "This product includes software developed by the
 *        Apache Software Foundation (http://www.apache.org/)."
 *    Alternately, this acknowlegement may appear in the software itself,
 *    if and wherever such third-party acknowlegements normally appear.
 *
 * 4. The names "The Jakarta Project", "Velocity", and "Apache Software
 *    Foundation" must not be used to endorse or promote products derived
 *    from this software without prior written permission. For written
 *    permission, please contact apache@apache.org.
 *
 * 5. Products derived from this software may not be called "Apache"
 *    nor may "Apache" appear in their names without prior written
 *    permission of the Apache Group.
 *
 * THIS SOFTWARE IS PROVIDED ``AS IS'' AND ANY EXPRESSED OR IMPLIED
 * WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 * OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED.  IN NO EVENT SHALL THE APACHE SOFTWARE FOUNDATION OR
 * ITS CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF
 * USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT
 * OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF
 * SUCH DAMAGE.
 * ====================================================================
 *
 * This software consists of voluntary contributions made by many
 * individuals on behalf of the Apache Software Foundation.  For more
 * information on the Apache Software Foundation, please see
 * <http://www.apache.org/>.
 */

import java.io.File;

import org.apache.velocity.anakia.AnakiaTask;

import org.apache.velocity.VelocityContext;
import org.apache.velocity.runtime.Runtime;
import org.apache.velocity.util.StringUtils;

import junit.framework.TestCase;

/**
 * This is a test case for Texen. Simply executes a simple
 * generative task and compares the output.
 *
 * @author <a href="mailto:jvanzyl@apache.org">Jason van Zyl</a>
 * @version $Id: TexenTestCase.java,v 1.1 2001/03/19 06:36:31 jvanzyl Exp $
 */
public class TexenTestCase extends TestCase
{
    /**
     * Directory where comparison output is stored.
     */
    private static final String COMPARE_DIR = "../test/texen/compare";
    
    /**
     * Directory where results are generated.
     */
    private static final String RESULTS_DIR = "../test/texen/results";

    /**
     * Creates a new instance.
     *
     */
    public TexenTestCase()
    {
        super("TexenTestCase");
    }

    public static junit.framework.Test suite()
    {
        return new TexenTestCase();
    }

    /**
     * Sets up the test.
     */
    protected void setUp ()
    {
    }

    /**
     * Runs the test.
     */
    public void runTest ()
    {
        try
        {
            if (!isMatch("TurbineWeather") ||
                !isMatch("TurbineWeatherService") ||
                !isMatch("WeatherService"))
            {
                fail("Output is incorrect!");
            }
        }            
        catch(Exception e)
        {
            /*
             * do nothing.
             */
        }
    }

    /**
     * Concatenates the file name parts together appropriately.
     *
     * @return The full path to the file.
     */
    private static String getFileName (String dir, String base, String ext)
    {
        StringBuffer buf = new StringBuffer();
        if (dir != null)
        {
            buf.append(dir).append('/');
        }
        buf.append(base).append('.').append(ext);
        return buf.toString();
    }

    /**
     * Turns a base file name into a test case name.
     *
     * @param s The base file name.
     * @return  The test case name.
     */
    private static final String getTestCaseName (String s)
    {
        StringBuffer name = new StringBuffer();
        name.append(Character.toTitleCase(s.charAt(0)));
        name.append(s.substring(1, s.length()).toLowerCase());
        return name.toString();
    }

    /**
     * Returns whether the processed template matches the content of the 
     * provided comparison file.
     *
     * @return Whether the output matches the contents of the comparison file.
     *
     * @exception Exception Test failure condition.
     */
    protected boolean isMatch (String file) throws Exception
    {
        String result = StringUtils.fileContentsToString
            (getFileName(RESULTS_DIR, file, "java"));
            
        String compare = StringUtils.fileContentsToString
             (getFileName(COMPARE_DIR, file, "java"));

        return result.equals(compare);
    }

    /**
     * Performs cleanup activities for this test case.
     */
    protected void tearDown () throws Exception
    {
        /* No op. */
    }
}