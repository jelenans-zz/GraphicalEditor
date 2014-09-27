package gge.state;

import static org.junit.Assert.*;
import gge.model.GGEModel;
import gge.view.GGEView;

import org.junit.Before;
import org.junit.Test;

public class TestStateManager {

	StateManager manager;
	
	@Before
	public void setUp() {
		GGEModel model = new GGEModel();
		manager = new StateManager(model, new GGEView(model,null));
	}
	
	@Test
	public void testStateManagerInitialization() {
		assertSame(manager.getCurrentState().getClass(), SelectElementState.class);
	}

	@Test
	public void testSetCurrentState() {
		fail("Not yet implemented");
	}

}
