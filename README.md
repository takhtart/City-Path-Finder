# Assignment A3: Island Generator

  - Author #1 [takhtart@mcmaster.ca]
  - Author #2 [sok13@mcmaster.ca]
  - Author #3 [kugana7@mcmaster.ca]

## How to run the product

Grid Mesh Procedure:
`mvn package`
`java -jar generator/target/2aa4.mesh.generator-jar-with-dependencies.jar -k grid -h 1000 -w 1000 -p 1000 -s 20 -o img/grid.mesh`
`java -jar visualizer/target/2aa4.mesh.visualizer-jar-with-dependencies.jar img/sample.mesh visualizer/sample.svg`

Irregular Mesh Procedure:
`mvn package`
`java -jar generator/target/2aa4.mesh.generator-jar-with-dependencies.jar -k irregular -h 1000 -w 1000 -p 1000 -s 20 -o img/irregular.mesh`
`java -jar visualizer/target/2aa4.mesh.visualizer-jar-with-dependencies.jar img/sample.mesh visualizer/sample.svg`

One can run the generator with `-help` as option to see the different command line arguments that are available

Island Mesh Procedure:

For MVP Release:
`java -jar island/target/2aa4.mesh.island-jar-with-dependencies.jar -i img/irregular.mesh <options> -o img/island.mesh`
`java -jar visualizer/target/2aa4.mesh.visualizer-jar-with-dependencies.jar img/island.mesh visualizer/sample.svg`

One can run the generator with `-help` as option to see the different command line arguments that are available.

`-mode lagoon` is required to generate the island. Optional: Can Control Inner And Outer Radius of Shape `-help` for more info.
Optional commands: `-ir` inner radius, `-or` outer radius.

For Final Release:

For the Island Mesh The Following Commands Are Mandatory:
`-shape` (Choosing Shape) (`-mode` is deprecated)

**For Reproductability:
If using `-shape random` it will provide you with a seed that can be invoked using `-ns <seed value>` (To Reproduce Island)
When Generating Lakes, Rivers And Aquifers a seed it will be provided you with a seed that can be invoked using `-seed <seed value>`
NOTE: the -seed command only controls positional randomness, when calling the seed you still need to indicate the amount of rivers, lakes, and aquifers that need to be generated (as the point of the seed is to control randomness so that all the decisions taken are the same when regenerating)

NOTE: that when regenerating the irregular mesh or grid mesh, the reproductability of lakes, rivers, and aquifers will not remain the same (due to order of polygons changing), You must use the initial irregular/grid mesh to reproduce lakes, rivers, and aquifers in the same positions.

One can run the generator with `-help` as option to see the different command line arguments that are available.

### Installation instructions

This product is handled by Maven, as a multi-module project. We assume here that you have cloned the project in a directory named `A3`

To install the different tooling on your computer, simply run:

```
mosser@azrael A3 % mvn install
```

After installation, you'll find an application named `generator.jar` in the `generator` directory, and a file named `visualizer.jar` in the `visualizer` one. 

### Generator

To run the generator, go to the `generator` directory, and use `java -jar` to run the product. The product takes one single argument (so far), the name of the file where the generated mesh will be stored as binary.

```
mosser@azrael A2 % cd generator 
mosser@azrael generator % java -jar generator.jar sample.mesh
mosser@azrael generator % ls -lh sample.mesh
-rw-r--r--  1 mosser  staff    29K 29 Jan 10:52 sample.mesh
mosser@azrael generator % 
```

### Visualizer

To visualize an existing mesh, go the the `visualizer` directory, and use `java -jar` to run the product. The product take two arguments (so far): the file containing the mesh, and the name of the file to store the visualization (as an SVG image).

```
mosser@azrael A2 % cd visualizer 
mosser@azrael visualizer % java -jar visualizer.jar ../generator/sample.mesh sample.svg

... (lots of debug information printed to stdout) ...

mosser@azrael visualizer % ls -lh sample.svg
-rw-r--r--  1 mosser  staff    56K 29 Jan 10:53 sample.svg
mosser@azrael visualizer %
```
To viualize the SVG file:

  - Open it with a web browser
  - Convert it into something else with tool slike `rsvg-convert`

## How to contribute to the project

When you develop features and enrich the product, remember that you have first to `package` (as in `mvn package`) it so that the `jar` file is re-generated by maven.

### Definition of Done

-- Feature is Fully Implemented And Tested --

### Backlog

| Id | Feature title | Who? | Start | End | Status |
|:--:|---------------|------|-------|-----|--------|
| F01 | Create lagoon islands with ocean, beach and lagoon | Team | 03/10/2023 | 03/13/2023 | D | 
| F02 | Shapes | Team | 03/15/2023 | 03/16/2023 | D | 
| F03 | Elevation | Kyen | 03/15/2023 | 03/26/2023 | D |
| F04 | Lakes | Aswin | 03/22/2023 | 03/25/2023 | D |
| F05 | Rivers | Aswin | 03/24/2023 | 03/26/2023 | D | 
| F06 | Aquifers | Kyen | 03/24/2023 | 03/25/2023 | D | 
| F07 | Soil absorption | Aswin | 03/26/2023 | 03/26/2023 | D |
| F08 | Biomes/Whittaker diagrams | Tarnveer | 03/24/2023 | 03/26/2023 | D |
| F09 | Reproductibility | Tarnveer | 03/15/2023 | 03/29/2023 | D | 
| F10 | Graph ADT | Tarnveer | 04/08/2023 | 04/10/2023 | D | 
| F11 | Interface to define the public contract of “finding a path between two nodes". | Tarnveer | 04/10/2023 | 04/11/2023 | D | 
| F12 | Implementation of a pathfinder algorithm to find a (shortest) path between two nodes | Tarnveer | 04/10/2023 | 04/11/2023 | D | 
| F13 | Add Pathfinder library as a dependency of the generator project | Tarnveer | 04/11/2023 | 04/11/2023 | D | 
| F14 | Enrich island generator project to add cities of different sizes (from small hamlets to big capital cities) to the islands. | Tarnveer | 04/11/2023 | 04/12/2023 | D | 
| F15 | Use pathfinder library to create a “star network” of roads on the island | Tarnveer | 04/12/2023 | 04/12/2023 | D | 
| F16 | Control number of cities via command line parameter | Tarnveer |04/11/2023 | 04/12/2023 | D | 



