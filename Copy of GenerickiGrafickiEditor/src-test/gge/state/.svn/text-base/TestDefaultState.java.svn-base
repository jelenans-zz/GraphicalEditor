package gge.state;

import static org.junit.Assert.*;

import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;

import gge.model.Atribute;
import gge.model.GGEModel;
import gge.model.GraphElement;
import gge.view.GGEView;
import gui.PopUp;

import org.junit.Before;
import org.junit.Test;

public class TestDefaultState {

	SelectElementState state;
	
	@Before
	public void setUp() {
		GGEModel model = new GGEModel();
		state = new SelectElementState(new GGEViewMockup(model));
	}

	@Test
	public void testMousePressed() {
		MouseEvent event = new MouseEvent(state.view, 0, 0, 0, 0, 0, 1, false, MouseEvent.BUTTON1);
		state.mousePressed(event);
		assertNotNull("Klik na element ne postavlja currentElement.", state.currentElement);
		
	}
	public void testMouseReleased(){
		MouseEvent event1 = new MouseEvent(state.view, 0, 0, 0, 0, 0, 1, false, MouseEvent.BUTTON1);
				state.mousePressed(event1);
				assertNotNull("Element nije selektovan", state.currentElement);
		MouseEvent event2 = new MouseEvent(state.view, 0, 0, 0, 0, 0, 1, false, MouseEvent.BUTTON3);
				state.mouseReleased(event2);
				assertNotNull("Kontekstni meni nije kreiran", state.currentElement);
	}

	@SuppressWarnings("serial")
	class GGEViewMockup extends GGEView {

		public GGEViewMockup(GGEModel model) {
			super(model, null);
		}

		@Override
		public GraphElement getElementAtPosition(Point2D position) {
			return new Atribute(new Point2D.Double(50, 35), new Dimension(100, 70));
		}
	}
	
}

