/* $Id$ */

package com.zoho.books.api;

import java.util.HashMap;

/**
 * API is the super class for all API class. It maintains the service URL and credential.
 *
 * @author ramesh-2099
 */

public class API {

    /**
     * This is the API base URL for Zoho Books service.
     */

    protected String baseURL = "https://www.zohoapis.com/books/v3";    //No I18N
    private String basURLEu = "https://www.zohoapis.eu/books/v3";
    protected String accessToken;

    protected String organizationId;

    /**
     * Construct a new API using access token and organization ID.
     *
     * @param accessToken OAuth access token.
     * @param organizationId User's organizationId.
     */

    public API(String accessToken, String organizationId) {
        this(accessToken, organizationId, false);
    }

    public API(String accessToken, String organizationId, boolean eu) {
      this.accessToken = accessToken;
      this.organizationId = organizationId;
      if(eu) {
        this.baseURL = basURLEu;
      }
		}


		/**
		 * Construct a queryMap containing organization_id.
		 *
		 * @return Returns a HashMap.
		 */

		public HashMap<String, Object> getQueryMap()
		{

				HashMap<String, Object> queryMap = new HashMap<String, Object>();

        queryMap.put("organization_id", organizationId);

        return queryMap;

    }


    /**
     * Construct a queryMap with the provided query string parameters, and add organization_id.
     *
     * @param queryMap This queryMap contains the query string parameters.
		 * @return Returns a HashMap.
		 */

		public HashMap<String, Object> getQueryMap(HashMap<String, Object> queryMap)
		{

				if(queryMap == null || queryMap.isEmpty())
				{
						queryMap = new HashMap<String, Object>();
				}

        queryMap.put("organization_id", organizationId);

        return queryMap;

    }
}
