package org.vaadin.jeanchristophe;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.dependency.JavaScript;
import com.vaadin.flow.component.dependency.NpmPackage;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.dom.Element;
import com.vaadin.flow.function.SerializableConsumer;
import elemental.json.Json;
import elemental.json.JsonArray;


/**
 * @author jcgueriaud
 */
@NpmPackage(value = "ngl", version = "0.10.4")
//@JavaScript("https://cdn.rawgit.com/arose/ngl/v0.10.4-1/dist/ngl.js")
@JavaScript("./src/ngl-connector.js")
public class NGLComponent extends Div {

    public NGLComponent() {
        initConnector(getElement());
    }


    private void initConnector(Element layout) {
        runBeforeClientResponse(ui -> ui.getPage().executeJs(
                "window.Vaadin.Flow.nglConnector.initLazy($0)",
                getElement()));
    }

    private void runBeforeClientResponse(SerializableConsumer<UI> command) {
        getElement().getNode().runWhenAttached(ui -> ui
                .beforeClientResponse(this, context -> command.accept(ui)));
    }

    public void loadFile(String file) {
        runBeforeClientResponse(ui -> getElement()
                .callJsFunction("$connector.loadFile", file));
    }
}
