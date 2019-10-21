package com.company;
import java.util.*;
public class TopologicalSort {
    public static List<Integer> topologicalSort(List<Integer> jobs, List<Integer[]> deps) {
        JobGraph jobgraph = createGraph(jobs, deps);
        return getOrderedJobs(jobgraph);
    }
    public static List<Integer> getOrderedJobs(JobGraph graph) {
        List<Integer> orderedJobs = new ArrayList<>();
        List<JobNode> nodes = new ArrayList<>(graph.nodes);
        while(nodes.size() > 0) {
            JobNode node = nodes.get(nodes.size() - 1);
            nodes.remove(nodes.size() - 1);
            boolean containsCycle = depthFirstTraverse(node, orderedJobs);
            if(containsCycle) {
                return new ArrayList<>();
            }
        }
        return orderedJobs;
    }
    public static boolean depthFirstTraverse(JobNode node, List<Integer> orderedJobs) {
        if(node.visited) return false;
        if(node.visiting) return true;
        node.visiting = true;
        for(JobNode prereqNode : node.prereqs) {
            boolean containsCycle = depthFirstTraverse(prereqNode, orderedJobs);
            if(containsCycle) return true;
        }
        node.visited = true;
        node.visiting = false;
        orderedJobs.add(node.job);
        return false;
    }
    public static JobGraph createGraph(List<Integer> jobs, List<Integer[]> deps) {
        JobGraph jobgraph = new JobGraph(jobs);
        for(Integer[] prereq : deps) {
            jobgraph.addPrereq(prereq[1], prereq[0]);
        }
        return jobgraph;
    }
    static class JobGraph {
        public List<JobNode> nodes;
        public HashMap<Integer, JobNode> graph;
        public JobGraph(List<Integer> jobs) {
            nodes = new ArrayList<>();
            graph = new HashMap<>();
            for(int job : jobs) {
                addNode(job);
            }

        }
        public void addNode(int job) {
            graph.put(job, new JobNode(job));
            nodes.add(graph.get(job));
        }
        public void addPrereq(int job, int prereq) {
            JobNode jobNode = getNode(job);
            JobNode prereqNode = getNode(prereq);
            jobNode.prereqs.add(prereqNode);
        }
        public JobNode getNode(int job) {
            if(!graph.containsKey(job)) addNode(job);
            return graph.get(job);
        }
    }

    public static class JobNode {
        public int job;
        public List<JobNode> prereqs;
        public boolean visited;
        public boolean visiting;
        public JobNode(int job) {
            this.job = job;
            prereqs = new ArrayList<>();
            visited = false;
            visiting = false;
        }
    }
    public static void main(String[] args) {
        List<Integer> jobs = new ArrayList<>();
        jobs.add(1);
        jobs.add(2);
        jobs.add(3);
        jobs.add(4);
        List<Integer[]> deps = new ArrayList<>();
        deps.add(new Integer[]{1,2});
        deps.add(new Integer[]{1,3});
        deps.add(new Integer[]{3,2});
        deps.add(new Integer[]{4,2});
        deps.add(new Integer[]{4,3});
        List<Integer> result = topologicalSort(jobs, deps);
        System.out.print(result);
    }
}
