from importlib.abc import FileLoader
from xml.dom import minidom
from jinja2 import Environment, FileSystemLoader 

# Parse xml file
results_xml = minidom.parse("results/1/unit-metric-scores.xml").getElementsByTagName('results')[0]

algorithms_xml =  results_xml.getElementsByTagName("algorithm") 
problems_xml =algorithms_xml[0].getElementsByTagName("problem")

# Extract the data from xml format
problems = []

for problem_xml in problems_xml:
    problems.append(problem_xml.attribute["name"])

results = []

for algorithm_xml in algorithms_xml:
    result = {}
    # todo
    results.append[result]


# fileLoader = FileSystemLoader("templates")
# env = Environment(loader=fileLoader)

# rendered = env.get_template("results.html").render()