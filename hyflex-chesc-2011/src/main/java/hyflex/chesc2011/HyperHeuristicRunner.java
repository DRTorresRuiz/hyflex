package hyflex.chesc2011;

/**
 * 
 * An example of how to use Lean-GIHH to solve an instance of the HyFlex benchmark.
 * 
 * @author Steven Adriaensen
 *         
 *         Class modification
 *         @author David Omrai
 * 
 */
import AbstractClasses.HyperHeuristic;
import AbstractClasses.ProblemDomain;

import PersonnelScheduling.PersonnelScheduling;

import SAT.SAT;

import be.kuleuven.kahosl.acceptance.AcceptanceCriterionType;
import be.kuleuven.kahosl.hyperheuristic.GIHH;
import be.kuleuven.kahosl.selection.SelectionMethodType;

import fr.lalea.eph.EPH;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import kubalik.EvoCOPHyperHeuristic;
import leangihh.LeanGIHH;

import pearlhunter.PearlHunter;

import travelingSalesmanProblem.TSP;

import acuna.GISS;
import bader.Clean;
import bader.Clean02;
import csput.CSPUTGeneticHiveHyperHeuristic;
import elomari.elomariSS;
import gomez.HaeaHH;
import hsiao.HsiaoCHeSCHyperheuristic;
import jiang.sa_ilsHyperHeuristic;
import johnston.JohnstonBiasILS;
import johnston.JohnstonDynamicILS;
import laroseml.LaroseML;
import lehrbaum.LehrbaumHAHA;
import iridia.MyHyperHeuristic;
import khmassi.Ant_Q;
import shafi.ShafiXCJ;
import aco.ACO_HH;
import sim.SimSATS_HH;
import urli.Urli_AVEG_NeptuneHyperHeuristic;
import mcclymont.McClymontMCHHS;

public class HyperHeuristicRunner {
  /**
   * Main method of HyperHeuristicRunner class, it runs hyper-heuristic based on the user input.
   * @param args This example takes no command line arguments
   */
  public static void main(String[] args) {
    if (args.length < 3) {
      System.out.println("ERROR, not enough arguments, " + "(" + args.length + "/3)");
      return;
    }
    if (args.length > 3) {
      System.out.println("ERROR, too many arguments, " + "(" + args.length + "/3)");
      return;
    }
    if (args[2].matches("\\d+") == false) {
      System.out.println("ERROR, wrong number format");
      return;
    }
    //seed for random generatortor
    long seed = new Date().getTime();
    /**
     * Hyper heuristic to use.
     * ----------------------
     * GIHH (the winner)
     * LeanGIHH
     * PearlHunter
     * EPH
     * ISEA
     */
    final String algorithmName = args[0];
    
    /**
     * Problems.
     * -----------------
     * SAT
     * TSP
     * PersonnelScheduling
     */
    final String ProblemName = args[1];
    
    final int[] sat = {3,5,4,10,11};
    // final int[] bp  = {7,1,9,10,11};
    final int[] ps  = {5,9,8,10,11};
    // final int[] fs  = {1,8,3,10,11};
    final int[] tsp = {0,8,2,7,6};
    // final int[] vrp = {6,2,5,1,9};

    HashMap<String, int[]> instances = new HashMap<>();
    instances.put("SAT", sat);
    instances.put("TSP", tsp);
    instances.put("PersonnelScheduling", ps);

    //time we're allowed to optimize (600000ms = 10min)
    final long timeAllowed = Integer.parseInt(args[2]) * 1000;
    
    List<Double> output = new ArrayList<Double>();

    for (int i = 0; i < instances.get(ProblemName).length; i++) {
      ProblemDomain problem = HyperHeuristicRunner.createProblem(ProblemName, seed);
      HyperHeuristic algorithm = HyperHeuristicRunner.createAlgorithm(
          problem, algorithmName, seed, timeAllowed
      );
      
      int instanceIx = instances.get(ProblemName)[i];

      algorithm.setTimeLimit(timeAllowed);
      algorithm.loadProblemDomain(problem);
      problem.loadInstance(instanceIx);      

      //start optimizing
      System.out.println("Testing " + algorithm + " for " + timeAllowed 
          + " ms on " + problem.getClass().getSimpleName() + "[" + instanceIx + "]...");
      algorithm.run();

      //print out quality of best solution found
      System.out.println(algorithm.getBestSolutionValue());
      output.add(algorithm.getBestSolutionValue());
    }
    System.out.println(output);
  }

  private static HyperHeuristic createAlgorithm(
      ProblemDomain problem, 
      String algorithmName, 
      long seed, 
      long timeout
  ) {
    switch (algorithmName) {
      case "GIHH":
        return new GIHH(
        seed, 
        problem.getNumberOfHeuristics(), 
        timeout,
        "gihh",
        SelectionMethodType.AdaptiveLimitedLAassistedDHSMentorSTD, 
        AcceptanceCriterionType.AdaptiveIterationLimitedListBasedTA);
      case "LeanGIHH":
        return new LeanGIHH(seed);
      case "PearlHunter":
        return new PearlHunter(seed);
      case "EPH":
        return new EPH(seed);
      case "ISEA":
        return new EvoCOPHyperHeuristic(seed);
      case "GISS":
        return new GISS(seed);
      case "Clean":
        return new Clean(seed);
      case "Clean02":
        return new Clean02(seed);
      case "CSPUTGeneticHiveHyperHeuristic":
        return new CSPUTGeneticHiveHyperHeuristic(seed);
      case "elomariSS":
        return new elomariSS(seed);
      case "HaeaHH":
        return new HaeaHH(seed);
      case "HsiaoCHeSCHyperheuristic":
        return new HsiaoCHeSCHyperheuristic(seed);
      case "sa_ilsHyperHeuristic":
        return new sa_ilsHyperHeuristic(seed);
      case "JohnstonBiasILS":
        return new JohnstonBiasILS(seed);
      case "JohnstonDynamicILS":
        return new JohnstonDynamicILS(seed);
      case "LaroseML":
        return new LaroseML(seed);
      case "LehrbaumHAHA":
        return new LehrbaumHAHA(seed);
      case "MyHyperHeuristic":
        return new MyHyperHeuristic(seed);
      case "Ant_Q":
        return new Ant_Q(seed);
      case "ShafiXCJ":
        return new ShafiXCJ(seed);
      case "ACO_HH":
        return new ACO_HH(seed);
      case "SimSATS_HH":
        return new SimSATS_HH(seed);
      case "Urli_AVEG_NeptuneHyperHeuristic":
        return new Urli_AVEG_NeptuneHyperHeuristic(seed);
      case "McClymontMCHHS":
        return new McClymontMCHHS(seed);
      default:
        System.out.println("ERROR, " + algorithmName + " INVALID INPUT");
        return null;
    }
  }

  private static ProblemDomain createProblem(String problemName, long seed) {
    switch (problemName) {
      case "SAT":
        return new SAT(seed);
      case "TSP":
        return new TSP(seed);
      case "PersonnelScheduling":
        return new PersonnelScheduling(seed);
      default:
        System.out.println("ERROR, " + problemName + " INVALID INPUT");
        return null;
    }
  }
}
