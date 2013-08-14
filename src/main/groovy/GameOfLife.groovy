class GameOfLife {

    static def deltas = [(-1..1), (-1..1)].combinations() - [[0, 0]]

    static def nextGeneration(def livingCells = []) {
        livingCells.findAll { livingNeighbours(it, livingCells) in [2, 3] } +
                deadNeighbours(livingCells).findAll { livingNeighbours(it, livingCells) == 3 } as Set
    }

    static def deadNeighbours(def livingCells) {
        (allNeighbours(livingCells) - livingCells)
    }

    static def livingNeighbours(def cell, def livingCells) {
        livingCells.count { it in allNeighbours([cell]) }
    }

    static def allNeighbours(def cells) {
        cells.inject([] as Set) { result, cell ->
            deltas.collect { delta -> [cell[0] + delta[0], cell[1] + delta[1]] }
        }
    }

}
