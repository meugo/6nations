import grails.util.Environment
import info.savaged.sixnations.User
import info.savaged.sixnations.StoryWall
import info.savaged.sixnations.UserStory

class BootStrap {

    def init = { servletContext ->
        if (Environment.current != Environment.PRODUCTION) {
            def storyWall = new StoryWall()
            def userStory = new UserStory(
                title:'Create a user story',
                description:'As a BA, I want to create a user story, so that I can get some business value',
                acceptanceTest:'Given a story-wall, when I create a user story, then it should persist',
                estimatedStoryPoints:1
            )
            def user = new User(name:'david')
	    user.save()
            userStory.owner = user
	    userStory.save()
            storyWall.addToDefined userStory
	    storyWall.save()
        }
    }

    def destroy = {
    }
} 
