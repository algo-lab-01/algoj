package com.lab01.ds.graphs;

import java.util.*;
public class Graph<T> {

    private Map<T, List<T>> verticesMap = new HashMap<>();

    public List<T> getVertices(T v){
        return verticesMap.get(v);
    }
    public void addVertex(T v){
        verticesMap.put(v, new LinkedList<>());
    }

    public void addEdge(T src, T dest, boolean isBiDirectional){
        if(!verticesMap.containsKey(src)){
            addVertex(src);
        }
        if(!verticesMap.containsKey(dest)){
            addVertex(dest);
        }
        verticesMap.get(src).add(dest);
        if(isBiDirectional)
            verticesMap.get(dest).add(src);
    }

    public int getVertexCount(){
        return this.verticesMap.keySet().size();
    }

    public int getEdgeCount(boolean isBiDirectional){
        int count = 0;
    
        for(T key: verticesMap.keySet()){
            count += verticesMap.get(key).size();
        }
        if(isBiDirectional)
            count = count/2;
        return count;
    }

    public boolean hasVertex(T v){
        return verticesMap.containsKey(v);
    }

    public boolean hasEdge(T src, T dest){
        return verticesMap.containsKey(src) && verticesMap.get(src).contains(dest);
    }

    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        for(T key: verticesMap.keySet()){
            stringBuilder.append(key).append(": [ ");
            for(T v: verticesMap.get(key)){
                stringBuilder.append(v).append(" ");
            }
            stringBuilder.append("]\n");
        }
        return stringBuilder.toString();
    }
}
