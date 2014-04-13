package ru.mipt.cs.cluster.threshold;
import ru.mipt.cs.cluster.clustering.Partition;

public interface Threshold {
	boolean jobDone (Partition[] pixels);
}
