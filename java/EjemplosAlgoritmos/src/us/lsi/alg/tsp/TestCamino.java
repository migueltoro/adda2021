package us.lsi.alg.tsp;

import java.util.List;

import org.jgrapht.Graph;

import us.lsi.grafos.datos.Carretera;
import us.lsi.grafos.datos.Ciudad;
import us.lsi.graphs.Graphs2;
import us.lsi.graphs.alg.GraphAlg;
import us.lsi.graphs.virtual.EGraph;

public class TestCamino {

	public static void main(String[] args) {
		Graph<Ciudad,Carretera> graph1 = AuxiliaryTsp.leeGraph("ficheros/andalucia.txt");
		Graph<Ciudad,Carretera> graph2 = AuxiliaryTsp.completeGraph(graph1);
		List<Ciudad> camino = List.of(Ciudad.ofName("Sevilla"),
				Ciudad.ofName("Huelva"),
				Ciudad.ofName("Cordoba"),
				Ciudad.ofName("Almeria"),
				Ciudad.ofName("Malaga"),
				Ciudad.ofName("Algeciras"),
				Ciudad.ofName("Malaga"),
				Ciudad.ofName("Granada"));
		
		TravelVertex e1 = TravelVertex.of(graph2,camino);
		System.out.println(e1);
		EGraph<TravelVertex,TravelEdge> graph = Graphs2.simpleVirtualGraphLast(e1,v->v.weight);
		
		GraphAlg<TravelVertex,TravelEdge> ml = GraphAlg.local(graph,0.);
		ml.stream().forEach(v->System.out.println(v));
	}

}
