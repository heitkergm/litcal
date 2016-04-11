package com.dappermoose.litcal.init;


import javax.servlet.annotation.WebFilter;

import org.sitemesh.builder.SiteMeshFilterBuilder;
import org.sitemesh.config.ConfigurableSiteMeshFilter;
import org.sitemesh.content.tagrules.html.DivExtractingTagRuleBundle;

// TODO: Auto-generated Javadoc
/**
 * The Class SitemeshFilter.
 */
@WebFilter (urlPatterns = { "/*" })
public class SitemeshFilter extends ConfigurableSiteMeshFilter
{

    /*
     * (non-Javadoc)
     *
     * @see
     * org.sitemesh.config.ConfigurableSiteMeshFilter#applyCustomConfiguration
     * (org.sitemesh.builder.SiteMeshFilterBuilder)
     */
    @Override
    protected void applyCustomConfiguration (final SiteMeshFilterBuilder builder)
    {
        builder.addDecoratorPath ("/*", "/WEB-INF/decorator/decorator.html");
        builder.addTagRuleBundle (new DivExtractingTagRuleBundle ());
    }
}
