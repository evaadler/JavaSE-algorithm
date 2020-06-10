package cleancode.old.fitness;

/**
 * HtmlUtilv2
 * 函数应该尽量短小
 *
 * @author Alicia
 * @description
 * @date 2020/6/10
 */
public class HtmlUtilv2 {
    public static String renderPageWithSetupsAndTearDowns(PageData pageData, boolean isSuite) throws Exception{
        boolean isTestPage = pageData.hasAttribute("Test");
        if (isTestPage) {
            includeSetupAndTeardownPages(pageData, isSuite);
        }
        return pageData.getHtml();
    }

    private static void includeSetupAndTeardownPages(PageData pageData, boolean isSuite) {
    }
}
