storepoints
===========

A repository for list of projects part of store-points.com web portal. A retail portal for loyalty services and offers publishing. 

storepoints
===========

Storepoints consist of set of sample open-source project modules to provide cloud based loyalty services and store management in Liferay Portal and CouchDB as back-end NoSQL solution.

How to Run
1. Deploy storepoints-portlet  and storepoints-theme war files as Portlet and Theme respectively in Liferay Portal version 6.0 or latest. Create Page, add portlet and apply theme accordingly.
2. Deploy storepoints-services war file as web services in Tomcat server version  7.0 or latest. The web services provided here act as middleware services for all of the front-end calls from Liferay portal, mobile apps and appropriately make client calls  to the Statement of Record exists in CouchDB NoSQL database.
