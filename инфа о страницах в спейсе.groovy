import com.atlassian.confluence.pages.PageManager
import com.atlassian.confluence.spaces.SpaceManager
import com.atlassian.sal.api.component.ComponentLocator
import com.atlassian.confluence.setup.settings.SettingsManager


PageManager pageManager = ComponentLocator.getComponent(PageManager)
SpaceManager spaceManager = ComponentLocator.getComponent(SpaceManager)
SettingsManager settingsManager = ComponentLocator.getComponent(SettingsManager)

def space = spaceManager.getSpace("VKCSP")
def homePage = space.getHomePage()

def listOfPages = homePage.getDescendants() 
listOfPages.add(homePage)
String baseUrl = settingsManager.getGlobalSettings().getBaseUrl();

listOfPages.each {
log.warn "Page title: " + it.getTitle()
log.warn "Page Url: " + baseUrl + it.getUrlPath()
log.warn "PageID: " + it.getContentId()
}
