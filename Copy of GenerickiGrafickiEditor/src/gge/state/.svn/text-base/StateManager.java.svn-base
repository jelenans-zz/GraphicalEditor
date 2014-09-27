package gge.state;

import java.awt.geom.Point2D;

import gge.model.GGEModel;
import gge.state.State;
import gge.view.GGEView;


public class StateManager {
	
	public enum States {
		DEFAULT_STATE,
		ADD_ELEMENT_STATE,
		SELECT_ELEMENTS_STATE,
		LASSO_SELECTION_STATE,
		RESIZE_STATE,
		ZOOM_IN_STATE,
		ZOOM_OUT_STATE, LINK_STATE,MOVE_CANVAS,MOVE_STATE,
		DEFORM_LINK_STATE
		
	}

	private State currentState;
	private GGEModel model;
	private GGEView view;
	private boolean inDrag = false;
	private boolean inProperties=false;
	private double lassoStartX = -1;
	private double lassoStartY = -1;
	Point2D cp ; //connectionPoint kojoj se menja pozicija
	Point2D tackaPomeranjeDeo; //za pomeranje dela linka(izmedju dve breakpoints)



	public Point2D getTackaPomeranjeDeo() {
		return tackaPomeranjeDeo;
	}

	public void setTackaPomeranjeDeo(Point2D tackaPomeranjeDeo) {
		this.tackaPomeranjeDeo = tackaPomeranjeDeo;
	}

	public void setCp(Point2D cp) {
		this.cp = cp;
	}

	public boolean isInProperties() {
		return inProperties;
	}

	public void setInProperties(boolean inProperties) {
		this.inProperties = inProperties;
	}

	public boolean isInDrag() {
		return inDrag;
	}

	public void setInDrag(boolean inDrag) {
		this.inDrag = inDrag;
	}

	public StateManager(GGEModel model, GGEView view) {
		this.model = model;
		this.view = view;
		currentState = new SelectElementState(view);
	}

	public State getCurrentState() {
		return currentState;
	}

	public void setCurrentState(States newState) {
		switch (newState) {
			case DEFAULT_STATE: currentState = new SelectElementState(view); break;
			case ADD_ELEMENT_STATE: currentState = new AddElementState(view); break;
			case SELECT_ELEMENTS_STATE : currentState = new SelectElementState(view); break;
			case LASSO_SELECTION_STATE : {
				currentState = new LassoSelectionState(view,lassoStartX,lassoStartY);
				inDrag = true;
				break;
			}
			case RESIZE_STATE: currentState = new ResizeElementState(view);break;
			case ZOOM_IN_STATE: currentState = new ZoomState(view, 1); break;
			case ZOOM_OUT_STATE: currentState = new ZoomState(view, -1); break;
			case LINK_STATE: currentState= new ConnectElementsState(view);break;
			case MOVE_CANVAS: currentState=new MoveCanvasState(view);break;
			case MOVE_STATE: {
				currentState=new MoveElementState(view,lassoStartX,lassoStartY);
			}break;
			case DEFORM_LINK_STATE: currentState = new DeformLinkState(view, cp, tackaPomeranjeDeo);
			break;
			default: currentState = new SelectElementState(view); break;
		}
	}

	public void setLassoStart(double x, double y) {
		lassoStartX = x;
		lassoStartY = y;
		
	}

	
	 
	
}
