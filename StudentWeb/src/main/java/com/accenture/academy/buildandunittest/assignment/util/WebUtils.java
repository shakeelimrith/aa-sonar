package com.accenture.academy.buildandunittest.assignment.util;

import java.io.IOException;
import java.io.Serializable;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

@ManagedBean(name="commonUtils")
@ApplicationScoped
public class WebUtils implements Serializable {
	private static final long serialVersionUID = 1L;

	public void redirectWithGet() throws RedirectException {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		ExternalContext externalContext = facesContext.getExternalContext();
    	HttpServletRequest request = (HttpServletRequest)externalContext.getRequest();

    	StringBuilder requestURL = new StringBuilder();
    	requestURL.append(request.getRequestURL());
        String queryString = request.getQueryString();

        if (queryString != null) {
            requestURL.append('?').append(queryString).toString();
        }

        String url = requestURL.toString();
        try {
			externalContext.redirect(requestURL.toString());
		} catch (IOException e) {
			throw new RedirectException("Unable to rerirect to " + url);
		}

        facesContext.responseComplete();
	}
}
