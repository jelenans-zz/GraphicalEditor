package menu.actions;


import gge.model.Element;
import gge.model.GGEModel;
import gge.model.GraphElement;
import gge.model.Link;
import gge.model.Project;

import java.util.ArrayList;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

public class ModelConverter implements Converter {
	private GGEModel model;
	
	@Override
	public boolean canConvert(Class context) {
		// TODO Auto-generated method stub 
		return context.equals(GGEModel.class); 
	}

	@Override
	public void marshal(Object value, HierarchicalStreamWriter writer,
			MarshallingContext context) {
		// TODO Auto-generated method stub
		  model = (GGEModel) value;
		
		  
	        writer.startNode("dijagram");
	        writer.setValue(model.getName());
	        writer.endNode();
	        
	        writer.startNode("elements");
	        context.convertAnother(model.getElements());
	        writer.endNode();
	        
			writer.startNode("links");
			context.convertAnother(model.getElements());
			writer.endNode();
	        
	}

	@SuppressWarnings("unchecked")
	@Override
	public Object unmarshal(HierarchicalStreamReader reader,
			UnmarshallingContext context) {
		// TODO Auto-generated method stub
		GGEModel m = new GGEModel();
		

	ArrayList<Element> listElements = new ArrayList<Element>();	

		reader.moveDown();
		m.setName(reader.getValue());
		reader.moveUp();

		reader.moveDown();
		listElements = (ArrayList<Element>) context.convertAnother(model, ArrayList.class);
		reader.moveUp();

		for (Element e : listElements) {
			if (e instanceof GraphElement) {
				m.addElement(e);
			}else if(e instanceof Link){
				m.addElement(e);
			}
		}	
		return m;
	}
}
/*reader.moveDown();
listLinks = (ArrayList<Link>) context.convertAnother(model,
		ArrayList.class);
for (Link abstractLink : listLinks) {
	if (abstractLink != null) {
		m.addElement(abstractLink);

	}
reader.moveUp();


}*/	
