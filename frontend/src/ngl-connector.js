import * as NGL from "ngl/dist/ngl.js";

window.Vaadin.Flow.nglConnector = {

    initLazy: function (c) {
        // Check whether the connector was already initialized
        if (c.$connector) {
            return;
        }
        c.$connector = {
            //// functions
            loadFile : function(file) {
                c.$connector.stage.loadFile( file, { defaultRepresentation: true } );
            },
        };

        // Create NGL Stage object
        c.$connector.stage = new NGL.Stage( c );

        // Handle window resizing
        window.addEventListener( "resize", function( event ){
            c.$connector.stage.handleResize();
        }, false );

    }
}