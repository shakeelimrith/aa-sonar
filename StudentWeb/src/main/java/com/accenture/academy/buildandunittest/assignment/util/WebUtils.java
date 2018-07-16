package com.accenture.academy.buildandunittest.assignment.util;

import java.io.IOException;
import java.io.Serializable;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import com.accenture.academy.buildandunittest.assignment.exception.UnableToRedirectException;

@ManagedBean(name="commonUtils")
@ApplicationScoped
public class WebUtils implements Serializable {
	private static final long serialVersionUID = 1L;

	public void redirectWithGet() throws UnableToRedirectException {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		ExternalContext externalContext = facesContext.getExternalContext();
    	HttpServletRequest request = (HttpServletRequest)externalContext.getRequest();

    	StringBuilder urlBuilder = new StringBuilder();
    	String requestURL = request.getRequestURL().toString();
        String queryString = request.getQueryString();

        if (queryString != null) {
            urlBuilder.append(requestURL).append('?').append(queryString).toString();
        }
        
        String url = urlBuilder.toString();

        try {
			externalContext.redirect(urlBuilder.toString());
		} catch (IOException e) {
			throw new UnableToRedirectException("Unable to redirect to " + url);
		}

        facesContext.responseComplete();
	}
}
