package gge.model;

import static org.junit.Assert.*;

import java.awt.Dimension;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;


import org.junit.Before;
import org.junit.Test;



public class TestGGEModel {

private GGEModel testModel;
	
	@Before
	public void setUp() {
		testModel = new GGEModel();
	}
	

	@Test
	public void testAddElement() {
		Atribute noviElement = new Atribute(new Point2D.Double(50, 35), new Dimension(100, 70));
		testModel.addElement(noviElement);
		assertSame("Element u listi nije isti kao dodati element.", testModel.getElement(0), noviElement);
	}
	
	
	@Test
	
	public void testAddNullElement(){
		testModel.addElement(null);
		assertEquals("Povecana velicina liste nakon dodavanja null elementa",0, testModel.elements.size());
		
	}
	
	@Test
	
	public void testAddPraznaLista(){
		Atribute noviElement = new Atribute(new Point2D.Double(50, 35), new Dimension(100, 70));
		testModel.addElement(noviElement);
		assertNotNull(testModel.getElements());
		
	}
	
	@Test
	
	public void testAddVecPostojeci(){
		Atribute noviElement = new Atribute(new Point2D.Double(50, 35), new Dimension(100, 70));
		testModel.addElement(noviElement);
		testModel.addElement(noviElement);
		
		assertEquals("Dodata 2 ista el",1, testModel.elements.size());
		
	}
	
	
	@Test
	
	public void testAddTipElementa(){
		
		Atribute noviElement = new Atribute(new Point2D.Double(50, 35), new Dimension(100, 70));
		testModel.addElement(noviElement);
		assertEquals("Pogresan tip elementa","elipsa",testModel.getElement(0).name);
		
	}

	@Test
	public void testRemoveElement() {
		Atribute atr = new Atribute(new Point2D.Double(50, 35), new Dimension(100, 70));
		testModel.addElement(atr);
		testModel.removeElement(atr);
		assertTrue("Prazna je lista elemenata jer smo obrisali postojeci.", testModel.elements.isEmpty());
	}
	@Test
	public void testRemoveAll() {
		Atribute atr = new Atribute(new Point2D.Double(50, 35), new Dimension(100, 70));
		Atribute atr1 = new Atribute(new Point2D.Double(50, 35), new Dimension(100, 70));
		Atribute atr2 = new Atribute(new Point2D.Double(50, 35), new Dimension(100, 70));
		testModel.addElement(atr);
		testModel.addElement(atr1);
		testModel.addElement(atr2);
		testModel.removeAllElements();
		assertTrue("Prazna je lista elemenata jer smo obrisali postojeci.", testModel.elements.isEmpty());
	}
	
	@Test
	public void testGetElementAtIndexTrue() {
		Atribute atr = new Atribute(new Point2D.Double(50, 35), new Dimension(100, 70));
		Atribute atr2 = new Atribute(new Point2D.Double(50, 35), new Dimension(100, 70));
		testModel.addElement(atr);//indeks 0
		testModel.addElement(atr2);//indeks 1
		assertSame(atr, testModel.elements.get(0));
	}
	@Test
	public void testGetElementAtIndexFalse() {
		Atribute atr = new Atribute(new Point2D.Double(50, 35), new Dimension(100, 70));
		Atribute atr2 = new Atribute(new Point2D.Double(50, 35), new Dimension(100, 70));
		testModel.addElement(atr);//indeks 0
		testModel.addElement(atr2);//indeks 1
		assertNotSame(atr, testModel.elements.get(1));
	}
	@Test
	public void testGetElementCount() {
		Atribute atr = new Atribute(new Point2D.Double(50, 35), new Dimension(100, 70));
		Atribute atr2 = new Atribute(new Point2D.Double(50, 35), new Dimension(100, 70));
		testModel.addElement(atr);//indeks 0
		testModel.addElement(atr2);//indeks 1
		assertSame(2, testModel.elements.size());
	}
	@Test
	public void testGetElementCountIfEmpty() {
		assertSame(0, testModel.elements.size());
	}
	
	@Test
	public void testGetElementIndexIfExists() {
		Atribute atr = new Atribute(new Point2D.Double(50, 35), new Dimension(100, 70));
		Atribute atr2 = new Atribute(new Point2D.Double(50, 35), new Dimension(100, 70));
		testModel.addElement(atr);//indeks 0
		testModel.addElement(atr2);//indeks 1
		assertSame(1, testModel.getElementIndex(atr2));
	}
	
	@Test
	public void testGetElementIndexIfNotExists() {
		Atribute atr = new Atribute(new Point2D.Double(50, 35), new Dimension(100, 70));
		Atribute atr2 = new Atribute(new Point2D.Double(50, 35), new Dimension(100, 70));
		testModel.addElement(atr);//indeks 0
		
		assertSame(-1, testModel.getElementIndex(atr2));
	}
	
	@Test
	public void testResizeElement(){
		Atribute atr = new Atribute(new Point2D.Double(50, 35), new Dimension(100, 70));
		testModel.addElement(atr); // dodat element u model sa velicinom 100,70
		Dimension novaDimenzija = new Dimension(500,200);
		testModel.resizeElement(atr, atr.getPosition(),novaDimenzija );
		assertSame(novaDimenzija, ((GraphElement) testModel.getElement(0)).getSize());
	}
	
	@Test
	public void testChangeConnectionPoint(){
		Atribute first = new Atribute(new Point2D.Double(50, 35), new Dimension(100, 70));
		Atribute second = new Atribute(new Point2D.Double(50, 35), new Dimension(100, 70));
		testModel.addElement(first);
		testModel.addElement(second);
		ArrayList<Point2D> breakPoints = new ArrayList<Point2D>();
		breakPoints.add(new Point2D.Double(128, 55));
		
		Point2D tacka = new Point2D.Double(155, 77);
		breakPoints.add(tacka);
		Link l = new Link();
		l.setFirst(first);
		l.setSecond(second);
		l.setBreakPoints(breakPoints);
		testModel.addElement(l);
		Point2D newCp = new Point2D.Double(14, 12);
		testModel.changeConnectionPoint(l,tacka, newCp);
		assertSame(newCp, l.getBreakPoints().get(1));
		
	}
	@Test
	public void testChangeConnectionPointIfNoLinkIsAddedInModel(){
		Atribute first = new Atribute(new Point2D.Double(50, 35), new Dimension(100, 70));
		Atribute second = new Atribute(new Point2D.Double(50, 35), new Dimension(100, 70));
		testModel.addElement(first);
		testModel.addElement(second);
		ArrayList<Point2D> breakPoints = new ArrayList<Point2D>();
		breakPoints.add(new Point2D.Double(128, 55));
		
		Point2D tacka = new Point2D.Double(155, 77);
		breakPoints.add(tacka);
		Link l = new Link();
		l.setFirst(first);
		l.setSecond(second);
		l.setBreakPoints(breakPoints);
		//testModel.addElement(l);
		Point2D newCp = new Point2D.Double(14, 12);
		testModel.changeConnectionPoint(l,tacka, newCp);
		assertNotSame(newCp, tacka);
		
	}
	@Test
	public void testChangeConnectionPointIfPointDoesntExistInLink(){
		Connector first = new Connector(new Point2D.Double(50, 35), new Dimension(100, 70));
		Entity second = new Entity(new Point2D.Double(50, 35), new Dimension(100, 70));
		testModel.addElement(first);
		testModel.addElement(second);
		ArrayList<Point2D> breakPoints = new ArrayList<Point2D>();
		breakPoints.add(new Point2D.Double(128, 55));
		
		Point2D tacka = new Point2D.Double(155, 77);
		//breakPoints.add(tacka);
		Link l = new Link();
		l.setFirst(first);
		l.setSecond(second);
		l.setBreakPoints(breakPoints);
		testModel.addElement(l);
		Point2D newCp = new Point2D.Double(14, 12);
		testModel.changeConnectionPoint(l,tacka, newCp);
		assertNotSame(newCp, tacka);
		
	}
	@Test
	public void testChangeLinkElementFirst(){
		Connector first = new Connector(new Point2D.Double(50, 35), new Dimension(100, 70));
		Entity second = new Entity(new Point2D.Double(50, 35), new Dimension(100, 70));
		testModel.addElement(first);
		testModel.addElement(second);
		ArrayList<Point2D> breakPoints = new ArrayList<Point2D>();
		breakPoints.add(new Point2D.Double(128, 55));	
		Point2D tacka = new Point2D.Double(155, 77);
		breakPoints.add(tacka);
		Link l = new Link();
		l.setFirst(first);
		l.setSecond(second);
		l.setBreakPoints(breakPoints);
		testModel.addElement(l);
		Entity newElement = new Entity(new Point2D.Double(13, 20), new Dimension(20, 80));
		testModel.changeLinkElement(l, 1, newElement);
		assertEquals(newElement, l.getFirst());
		
	}
	@Test
	public void testChangeLinkElementSecond(){
		Connector first = new Connector(new Point2D.Double(50, 35), new Dimension(100, 70));
		Entity second = new Entity(new Point2D.Double(50, 35), new Dimension(100, 70));
		testModel.addElement(first);
		testModel.addElement(second);
		ArrayList<Point2D> breakPoints = new ArrayList<Point2D>();
		breakPoints.add(new Point2D.Double(128, 55));	
		Point2D tacka = new Point2D.Double(155, 77);
		breakPoints.add(tacka);
		Link l = new Link();
		l.setFirst(first);
		l.setSecond(second);
		l.setBreakPoints(breakPoints);
		testModel.addElement(l);
		Entity newElement = new Entity(new Point2D.Double(13, 20), new Dimension(20, 80));
		testModel.changeLinkElement(l, 2, newElement);
		assertEquals(newElement, l.getSecond());
		
	}
	@Test
	public void testChangeLinkElementIfNewIsNull(){
		Connector first = new Connector(new Point2D.Double(50, 35), new Dimension(100, 70));
		Entity second = new Entity(new Point2D.Double(50, 35), new Dimension(100, 70));
		testModel.addElement(first);
		testModel.addElement(second);
		ArrayList<Point2D> breakPoints = new ArrayList<Point2D>();
		breakPoints.add(new Point2D.Double(128, 55));	
		Point2D tacka = new Point2D.Double(155, 77);
		breakPoints.add(tacka);
		Link l = new Link();
		l.setFirst(first);
		l.setSecond(second);
		l.setBreakPoints(breakPoints);
		testModel.addElement(l);
		Entity newElement = new Entity(new Point2D.Double(13, 20), new Dimension(20, 80));
		testModel.changeLinkElement(l, 2, null);
		assertNotNull("Drugi el se nije promenio!", l.getSecond());
		
	}
	
	@Test
	public void testMoveTwoPoints(){
		Connector first = new Connector(new Point2D.Double(50, 35), new Dimension(100, 70));
		Entity second = new Entity(new Point2D.Double(50, 35), new Dimension(100, 70));
		testModel.addElement(first);
		testModel.addElement(second);
		ArrayList<Point2D> breakPoints = new ArrayList<Point2D>();
		breakPoints.add(new Point2D.Double(128, 55));	
		Point2D tacka = new Point2D.Double(155, 77);
		breakPoints.add(tacka);
		Point2D tacka2 = new Point2D.Double(155, 14);
		breakPoints.add(tacka2);
		
		Link l = new Link();
		l.setFirst(first);
		l.setSecond(second);
		l.setBreakPoints(breakPoints);
		testModel.addElement(l);
		testModel.moveTwoPoints(l, tacka, tacka2, 14, 14);
		Object[] tacke = breakPoints.toArray();
		Object[] tackeIzLinka = l.getBreakPoints().toArray();
		assertArrayEquals(tacke, tackeIzLinka);
		
		
	}
	
}
