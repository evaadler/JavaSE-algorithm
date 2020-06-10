package cleancode.old.fitness;

/**
 * PageCrawler
 *
 * @author Alicia
 * @description
 * @date 2020/6/10
 */
public interface PageCrawler {
    WikiPagePath getFullPath(WikiPage suiteSetup);

    WikiPage getPage(WikiPage root, WikiPagePath path);

    void setDeadEndStrategy(VirtualEnabledPageCrawler virtualEnabledPageCrawler);
}
