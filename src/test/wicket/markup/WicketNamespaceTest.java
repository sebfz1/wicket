/*
 * $Id: WicketNamespaceTest.java 4507 2006-02-16 22:51:20 +0000 (Thu, 16 Feb
 * 2006) jonathanlocke $ $Revision$ $Date: 2006-02-16 22:51:20 +0000
 * (Thu, 16 Feb 2006) $
 * 
 * ==================================================================== Licensed
 * under the Apache License, Version 2.0 (the "License"); you may not use this
 * file except in compliance with the License. You may obtain a copy of the
 * License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package wicket.markup;

import junit.framework.TestCase;
import wicket.Page;
import wicket.protocol.http.MockWebApplication;
import wicket.util.diff.DiffUtil;

/**
 */
public class WicketNamespaceTest extends TestCase
{
	// private static Log log = LogFactory.getLog(WicketNamespaceTest.class);

	private MockWebApplication application;

	/**
	 * Create the test.
	 * 
	 * @param name
	 *            The test name
	 */
	public WicketNamespaceTest(String name)
	{
		super(name);
	}

	/**
	 * @throws Exception
	 */
	public void testRenderHomePage_1() throws Exception
	{
		executeTest(WicketNamespace_1.class, "WicketNamespaceExpectedResult_1.html");
	}

	/**
	 * @throws Exception
	 */
	public void testRenderHomePage_2() throws Exception
	{
		executeTest(WicketNamespace_2.class, "WicketNamespaceExpectedResult_2.html");
	}

	/**
	 * @throws Exception
	 */
	public void testRenderHomePage_3() throws Exception
	{
		executeTest(WicketNamespace_3.class, "WicketNamespaceExpectedResult_3.html");
	}

	/**
	 * @throws Exception
	 */
	public void testRenderHomePage_4() throws Exception
	{
		executeTest(WicketNamespace_4.class, "WicketNamespaceExpectedResult_4.html");
	}

	/**
	 * @throws Exception
	 */
	public void testRenderHomePage_5() throws Exception
	{
		executeTest(WicketNamespace_5.class, "WicketNamespaceExpectedResult_5.html");
	}

	/**
	 * @throws Exception
	 */
	public void testRenderHomePage_6() throws Exception
	{
		executeTest(WicketNamespace_6.class, "WicketNamespaceExpectedResult_6.html");
	}

	/**
	 * @param pageClass
	 * @param filename
	 * @throws Exception
	 */
	public void executeTest(final Class<? extends Page> pageClass, final String filename) throws Exception
	{
		System.out.println("=== " + pageClass.getName() + " ===");

		application = new MockWebApplication(null);
		application.setHomePage(pageClass);

		// Do the processing
		application.setupRequestAndResponse();
		application.processRequestCycle();

		// Validate the document
		String document = application.getServletResponse().getDocument();
		assertTrue(DiffUtil.validatePage(document, this.getClass(), filename));
	}
}
