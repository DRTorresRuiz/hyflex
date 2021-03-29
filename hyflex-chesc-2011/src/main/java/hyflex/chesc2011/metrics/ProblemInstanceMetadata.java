/**
 * @author David Omrai
 */

package hyflex.chesc2011.metrics;

import java.util.HashMap;
import java.util.Map;

public class ProblemInstanceMetadata {
  /**
   * .
   * String: instanceId
   *    - String: [optimum, random, size]
   *        - Double: instanceId parameter value
   */
  Map<String, Map<String, Double>> instanceResults;

  /**
   * Constructor, creates new map for instance's parameter results.
   */
  ProblemInstanceMetadata() {
    instanceResults = new HashMap<>();
  }

  /**
   * Method puts the given instance value.
   * @param instanceId Name of the instance.
   * @param parameter Name of the parameter.
   * @param value Value of the parameter.
   * @return Returns this.
   */
  public ProblemInstanceMetadata put(String instanceId, String parameter, Double value) {
    if (instanceResults.containsKey(instanceId) == false) {
      instanceResults.put(instanceId, new HashMap<>());
    }
    
    instanceResults.get(instanceId).put(parameter, value);
    return this;
  }

  /**
   * Method returns the instance result.
   * @param instanceId Name of the instance.
   * @param parameter Name of the parameter.
   * @return Parameter value of the instance.
   */
  public double get(String instanceId, String parameter) {
    return instanceResults.get(instanceId).get(parameter);
  }
}
