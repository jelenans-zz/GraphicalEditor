package gge.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestWorkspace {
	private Workspace workspace;
	@Before
	public void setUp() {
		workspace = new Workspace();
	}
	@Test
	public void testName(){
		workspace.setName("Workspace1");
		assertSame("Workspace1", workspace.getName());
	}
	@Test 
	public void testAddProjectInWorkspace(){
		Project project1 = new Project();
		workspace.addProject(project1);
		assertFalse(workspace.getProjects().isEmpty());
	}
	@Test 
	public void testAddNullProjectInWorkspace(){
		Project p1 = null;
		workspace.addProject(p1);
		assertTrue(workspace.getProjects().isEmpty());
	}
	
	@Test 
	public void testAddProjectTwiceInWorkspace(){
		Project p1 = new Project();
		workspace.addProject(p1);
		workspace.addProject(p1);
		assertSame(1,workspace.getProjectCount());
	}
	@Test
	public void testGetProjectAtIndex(){
		Project p1 = new Project();
		workspace.addProject(p1);
		assertSame(p1,workspace.getProject(0));
	}
	
	@Test 
	public void testRemoveProjectFromWorkspace(){
		Project p1 = new Project();
		workspace.addProject(p1);
		workspace.removeProject(p1);
		assertTrue(workspace.getProjects().isEmpty());
	}
	@Test 
	public void testRemoveNotExsistingFromWorkspace(){
		Project p1 = new Project();
		workspace.addProject(p1);
		Project p2 = new Project();
		workspace.removeProject(p2);
		assertSame(1,workspace.getProjects().size());
	}
	@Test 
	public void testRemoveAllProjectsFromWorkspace(){
		Project p1 = new Project();
		Project p2 = new Project();
		Project p3 = new Project();
		workspace.addProject(p1);
		workspace.addProject(p2);
		workspace.addProject(p3);
		workspace.removeAllProject();
		assertTrue(workspace.getProjects().isEmpty());
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
