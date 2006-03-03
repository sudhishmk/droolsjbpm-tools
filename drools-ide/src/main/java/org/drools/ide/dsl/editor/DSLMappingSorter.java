package org.drools.ide.dsl.editor;

import org.drools.lang.dsl.template.NLMappingItem;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerSorter;

/** 
 * Provides sorting for the natural language table viewer.
 * @author Michael Neale
 */
public class DSLMappingSorter extends ViewerSorter {

	public final static int EXPRESSION = 0;
	public final static int MAPPING = 1;
	public final static int SCOPE = 2;

	// Criteria that the instance uses 
	private int criteria;

	/**
	 * Creates a resource sorter that will use the given sort criteria.
	 *
	 * @param criteria the sort criterion to use: one of <code>NAME</code> or 
	 *   <code>TYPE</code>
	 */
	public DSLMappingSorter(int criteria) {
		super();
		this.criteria = criteria;
	}

	/* (non-Javadoc)
	 * Method declared on ViewerSorter.
	 */
	public int compare(Viewer viewer, Object o1, Object o2) {

		NLMappingItem item1 = (NLMappingItem) o1;
		NLMappingItem item2 = (NLMappingItem) o2;

		switch (criteria) {
			case EXPRESSION :
				return compareExpressions(item1, item2);
			case MAPPING :
				return compareMappings(item1, item2);
			case SCOPE :
				return compareScope(item1, item2);
			default:
				return 0;
		}
	}

	

	private int compareScope(NLMappingItem item1,
                             NLMappingItem item2) {
        return item1.getScope().compareTo( item2.getScope() );
    }

    private int compareMappings(NLMappingItem item1,
                                NLMappingItem item2) {
        return item1.getScope().compareTo( item2.getScope() );
    }

    private int compareExpressions(NLMappingItem item1,
                                   NLMappingItem item2) {
        return item1.getNaturalTemplate().compareTo( item2.getNaturalTemplate() );
    }

    /**
	 * @return the sort criterion
	 */
	public int getCriteria() {
		return criteria;
	}
}