/*
 * Copyright (c) 2002-2012, Mairie de Paris
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *  1. Redistributions of source code must retain the above copyright notice
 *     and the following disclaimer.
 *
 *  2. Redistributions in binary form must reproduce the above copyright notice
 *     and the following disclaimer in the documentation and/or other materials
 *     provided with the distribution.
 *
 *  3. Neither the name of 'Mairie de Paris' nor 'Lutece' nor the names of its
 *     contributors may be used to endorse or promote products derived from
 *     this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDERS OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 *
 * License 1.0
 */
package fr.paris.lutece.plugins.document.business;

import fr.paris.lutece.portal.service.spring.SpringContextService;

import java.util.List;


/**
 * This class provides instances management methods (create, find, ...) for DocumentPageTemplate objects
 */
public final class DocumentPageTemplateHome
{
    // Static variable pointed at the DAO instance
    private static IDocumentPageTemplateDAO _dao = SpringContextService.getBean( "document.documentPageTemplateDAO" );

    /** Creates a new instance of DocumentPageTemplateHome */
    private DocumentPageTemplateHome(  )
    {
    }

    /**
     * Creation of an instance of a document page template
     *
     * @param documentPageTemplate template An instance of a page template which contains the informations to store
     * @return The instance of a page template which has been created with its primary key.
     */
    public static DocumentPageTemplate create( DocumentPageTemplate documentPageTemplate )
    {
        _dao.insert( documentPageTemplate );

        return documentPageTemplate;
    }

    /**
     * Update of the page template which is specified
     *
     * @param documentPageTemplate The instance of the page template which contains the data to store
     * @return The instance of the page template which has been updated
     */
    public static DocumentPageTemplate update( DocumentPageTemplate documentPageTemplate )
    {
        _dao.store( documentPageTemplate );

        return documentPageTemplate;
    }

    /**
     * Remove the page template whose identifier is specified in parameter
     *
     * @param nId The identifier of the page template to remove
     */
    public static void remove( int nId )
    {
        _dao.delete( nId );
    }

    ///////////////////////////////////////////////////////////////////////////
    // Finders

    /**
     * Returns an instance of an page template whose identifier is specified in parameter
     *
     * @param nKey The page template primary key
     * @return an instance of a page template
     */
    public static DocumentPageTemplate findByPrimaryKey( int nKey )
    {
        return _dao.load( nKey );
    }

    /**
     * Return the list of all the page templates
     *
     * @return A collection of page templates objects
     */
    public static List<DocumentPageTemplate> getPageTemplatesList(  )
    {
        return _dao.selectPageTemplatesList(  );
    }
}
