package org.jboss.windup.reporting.service;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

import org.jboss.windup.graph.GraphContext;
import org.jboss.windup.graph.service.GraphService;
import org.jboss.windup.reporting.model.EffortReportModel;

/**
 * Contains methods for manipulating {@link EffortReportModel} instances.
 *
 * @author <a href="mailto:jesse.sightler@gmail.com">Jesse Sightler</a>
 */
public class EffortReportService extends GraphService
{
    private static Map<Integer, String> effortLevelDescriptionMap = Collections.synchronizedMap(new LinkedHashMap<Integer, String>());

    public static final String UNKNOWN = "Unknown";
    public static final String REQUIRES_ARCHITECTURAL_CHANGE = "Requires Architectural Change";
    public static final String REDESIGN = "Redesign";
    public static final String COMPLEX = "Complex";
    public static final String TRIVIAL = "Trivial";
    public static final String INFO = "Info";

    static
    {
        effortLevelDescriptionMap.put(0, INFO);
        effortLevelDescriptionMap.put(1, TRIVIAL);
        effortLevelDescriptionMap.put(3, COMPLEX);
        effortLevelDescriptionMap.put(5, REDESIGN);
        effortLevelDescriptionMap.put(7, REQUIRES_ARCHITECTURAL_CHANGE);
        effortLevelDescriptionMap.put(13, UNKNOWN);
    }

    public EffortReportService(GraphContext context)
    {
        super(context, EffortReportModel.class);
    }

    /**
     * Gets a mapping from effort level to a description.
     */
    public static Map<Integer, String> getEffortLevelDescriptionMappings()
    {
        return effortLevelDescriptionMap;
    }
}
