package cleancode.old.fitness;

/**
 * HtmlUtilv1
 *
 * @author Alicia
 * @description
 * @date 2020/6/10
 */
public class HtmlUtilv1 {
    public static String renderPageWithSetupsAndTearDowns(PageData pageData, boolean isSuite) throws Exception{
        boolean isTestPage = pageData.hasAttribute("Test");
        if (isTestPage) {
            WikiPage testPage = pageData.getWikiPage();
            StringBuffer newPageContent = new StringBuffer();
            includeSetupPages(testPage, newPageContent, isSuite);
            pageData.setContent(newPageContent.toString());
        }
        return pageData.getHtml();
    }

    private static void includeSetupPages(WikiPage testPage, StringBuffer newPageContent, boolean isSuite) {
    }
}
