package menu.actions;

import java.util.ArrayList;

import gge.model.Element;
import gge.model.GGEModel;
import gge.model.GraphElement;
import gge.model.Link;
import gge.model.Project;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

public class ProjectConverter implements Converter {
		
	private GGEModel model;
	private Project project;
	private int brdiagrama;

@Override
public boolean canConvert(Class cl) {
		return cl.equals(Project.class);
		}

@Override
public void marshal(Object value, HierarchicalStreamWriter writer,
				MarshallingContext context) {
			// TODO Auto-generated method stub
		project = (Project) value;
		
		writer.startNode("projectName");
		writer.setValue(project.getName());
		writer.endNode();
		
		brdiagrama=project.getDiagramCount();
			
		writer.startNode("numberOfDiagrams");
		writer.setValue(Integer.toString(brdiagrama));
		writer.endNode();
			
		for (int i=0; i < brdiagrama; i++){
			model =  project.getDiagram(i);
		
			writer.startNode("diagramName");
			writer.setValue(model.getName());
			writer.endNode();

			writer.startNode("elements");
			context.convertAnother(model.getElements());
			writer.endNode();

			writer.startNode("links");
			context.convertAnother(model.getElements());
			writer.endNode();
			}
		}

@SuppressWarnings("unchecked")
@Override
public Object unmarshal(HierarchicalStreamReader reader,
		UnmarshallingContext context) {
	// TODO Auto-generated method stub
	
	Project project2 = new Project();
	int brdijagrama2;

	//ArrayList<Element> listElements = new ArrayList<Element>();
	ArrayList<GGEModel> listModels = new ArrayList<GGEModel>();
	
	reader.moveDown();
	project2.setName(reader.getValue());
	reader.moveUp();
			
	reader.moveDown();
	brdijagrama2 = (Integer.parseInt(reader.getValue()));
	reader.moveUp();

		for (int i=0; i < brdijagrama2; i++){
			GGEModel model2 = new GGEModel();
			ArrayList<Element> listElements = new ArrayList<Element>();
			
			reader.moveDown();
			model2.setName(reader.getValue());
			reader.moveUp();

			reader.moveDown();
			listElements = (ArrayList<Element>) context.convertAnother(model, ArrayList.class);
			for (Element e : listElements) {
				if (e instanceof GraphElement) {
					model2.addElement(e);
				}else if(e instanceof Link){
					model2.addElement(e);
				}
			}
			/*for (Element graphElement : listElements) {
				if (graphElement!=null){
				model2.addElement(graphElement);
				}
			}*/
			listModels.add(model2);
			reader.moveUp();
			
			reader.moveDown();
			// ucitavanje veza
			reader.moveUp();
			
			project2.addGGEModel(model2);
		}
			
			return project2;
}


}
