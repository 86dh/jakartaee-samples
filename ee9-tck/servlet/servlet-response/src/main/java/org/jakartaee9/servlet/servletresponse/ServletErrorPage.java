/*
 * Copyright (c) 2007, 2020 Oracle and/or its affiliates. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0, which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * This Source Code may also be made available under the following Secondary
 * Licenses when the conditions for such availability set forth in the
 * Eclipse Public License v. 2.0 are satisfied: GNU General Public License,
 * version 2 with the GNU Classpath Exception, which is available at
 * https://www.gnu.org/software/classpath/license.html.
 *
 * SPDX-License-Identifier: EPL-2.0 OR GPL-2.0 WITH Classpath-exception-2.0
 */

/*
 * $Id$
 */

/*
 * $URL$ $LastChangedDate$
 */
package org.jakartaee9.servlet.servletresponse;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Simple Servlet-based error page that displays error related req attributes.
 */

public class ServletErrorPage extends HttpServlet {

    private static final long serialVersionUID = 1L;
    
    private static final String STATUS_CODE = RequestDispatcher.ERROR_STATUS_CODE; // "jakarta.servlet.error.status_code";
    private static final String EXCEPTION_TYPE = RequestDispatcher.ERROR_EXCEPTION_TYPE; //"jakarta.servlet.error.exception_type";
    private static final String MESSAGE = RequestDispatcher.ERROR_MESSAGE; //"jakarta.servlet.error.message";
    private static final String EXCEPTION = RequestDispatcher.ERROR_EXCEPTION; //"jakarta.servlet.error.exception"
    private static final String REQUEST_URI = RequestDispatcher.ERROR_REQUEST_URI; //"jakarta.servlet.error.request_uri";
    private static final String SERVLET_NAME = RequestDispatcher.ERROR_SERVLET_NAME; //"jakarta.servlet.error.servlet_name"
    private static final String EXP_MESSAGE = "error page invoked";

    /**
     * Invoked by container
     */
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter printWriter = response.getWriter();
        
        // display req attributes
        printWriter.println("Servlet Name: " + request.getAttribute(SERVLET_NAME));
        printWriter.println("Request URI: " + request.getAttribute(REQUEST_URI));
        printWriter.println("Status Code: " + request.getAttribute(STATUS_CODE));
        printWriter.println("Exception Type: " + request.getAttribute(EXCEPTION_TYPE));
        printWriter.println("Exception: " + request.getAttribute(EXCEPTION));
        printWriter.print("Message: ");
        
        if (((String) request.getAttribute(MESSAGE)).indexOf(EXP_MESSAGE) > -1) {
            printWriter.println(EXP_MESSAGE);
        }

    }
}
