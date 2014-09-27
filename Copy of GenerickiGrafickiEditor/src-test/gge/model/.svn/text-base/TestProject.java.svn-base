package gge.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestProject {

private Project project;
	
	@Before
	public void setUp() {
		project = new Project();
	}
	@Test
	public void testName(){
		project.setName("novi projekat");
		assertSame("novi projekat", project.getName());
	}
	@Test 
	public void testAddDiagramInProject(){
		GGEModel model1 = new GGEModel();
		project.addGGEModel(model1);
		assertFalse(project.getGGEModel().isEmpty());
	}
	@Test 
	public void testAddNullDiagramInProject(){
		GGEModel model1 = null;
		project.addGGEModel(model1);
		assertTrue(project.getGGEModel().isEmpty());
	}
	
	@Test 
	public void testAddDiagramTwiceInProject(){
		GGEModel model1 = new GGEModel();
		project.addGGEModel(model1);
		project.addGGEModel(model1);
		assertSame(1,project.getDiagramCount());
	}
	@Test
	public void testGetDiagramAtIndex(){
		GGEModel model1 = new GGEModel();
		project.addGGEModel(model1);
		assertSame(model1,project.getDiagram(0));
	}
	
	@Test 
	public void testRemoveDiagramFromProject(){
		GGEModel model1 = new GGEModel();
		project.addGGEModel(model1);
		project.removeGGEModel(model1);
		assertTrue(project.getGGEModel().isEmpty());
	}
	@Test 
	public void testRemoveNotExsistingFromProject(){
		GGEModel model1 = new GGEModel();
		project.addGGEModel(model1);
		GGEModel model2 = new GGEModel(); //nije dodat
		project.removeGGEModel(model2);
		assertSame(1,project.getGGEModel().size());
	}
	@Test 
	public void testRemoveAllDiagramsFromProject(){
		GGEModel model1 = new GGEModel();
		GGEModel model2 = new GGEModel();
		GGEModel model3 = new GGEModel();
		project.addGGEModel(model1);
		project.addGGEModel(model2);
		project.addGGEModel(model3);
		project.removeAllGGEModel();
		assertTrue(project.getGGEModel().isEmpty());
	}
	@Test 
	public void testOpen(){
		fail("Not yet implemented");
	}
	@Test 
	public void testClose(){
		fail("Not yet implemented");
	}
	@Test 
	public void testSave(){
		fail("Not yet implemented");
	}

}
