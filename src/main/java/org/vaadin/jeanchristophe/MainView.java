package org.vaadin.jeanchristophe;

import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.PWA;

/**
 * The main view contains a button and a click listener.
 */
@Route("")
public class MainView extends VerticalLayout {

    public MainView() {
        NGLComponent nglComponent = new NGLComponent();
        nglComponent.setSizeFull();
        //nglComponent.loadFile("rcsb://1CRN");
        Button changeModel1 = new Button("Model rcsb://1CRN", e -> {
            nglComponent.loadFile("rcsb://1CRN");
        });
        add(new HorizontalLayout(changeModel1),nglComponent);
        setSizeFull();
        setPadding(false);
    }
}
