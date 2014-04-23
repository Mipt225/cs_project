package ru.mipt.cs.cluster.threshold;
import ru.mipt.cs.cluster.kmeans.Cluster;

public interface Threshold {
	boolean jobDone (Cluster[] clusters);
}
