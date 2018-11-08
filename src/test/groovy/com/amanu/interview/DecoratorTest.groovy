package com.amanu.interview

import com.amanu.interview.view.HomeView
import com.amanu.interview.view.MainDecoratorView
import com.amanu.interview.view.View
import spock.lang.Specification

/**
 * @author Amanuel Nega on November 08, 2018.
 */


class DecoratorTest extends Specification {
    def "Verify decorator prepends the title correctly"() {
        given:
        View home = new HomeView(null)

        when:
        View decoratedView = new MainDecoratorView(home, null)

        then:
        decoratedView.title == "RPG::" + home.title
 
    }
    
    def "Verify decorator adds the exit menu correctly"() {
        given:
        View home = new HomeView(null)

        when:
        View decoratedView = new MainDecoratorView(home, null)

        then:
        decoratedView.menus.size() == home.menus.size() + 1
        
    }
    
    def "Verify decorator adds the header correctly"() {
        given:
        View home = new HomeView(null)

        when:
        View decoratedView = new MainDecoratorView(home, null)

        then:
        decoratedView.header != home.header
        
    }
}