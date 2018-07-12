package com.accenture.academy.buildandunittest.assignment.util;

import java.io.IOException;
import java.io.Serializable;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import com.accenture.academy.buildandunittest.assignment.exceptions.NewRuntimeException;

@ManagedBean(name="commonUtils")
@ApplicationScoped
public class WebUtils implements Serializable {
	private static final long serialVersionUID = 1L;

	public void redirectWithGet() throws NewRuntimeException {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		ExternalContext externalContext = facesContext.getExternalContext();
    	HttpServletRequest request = (HttpServletRequest)externalContext.getRequest();
    	
    	StringBuilder stringBuilder = new StringBuilder();
    	String requestURL = request.getRequestURL().toString();
        String queryString = request.getQueryString();

        if (queryString != null) {
            stringBuilder.append(requestURL).append('?').append(queryString).toString();
        }

        String url = requestURL;
        try {
			externalContext.redirect(requestURL);
		} catch (IOException e) {
			throw new NewRuntimeException("Unable to rerirect to " + url);
		}

        facesContext.responseComplete();
	}
}
