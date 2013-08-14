class GameOfLife {

    static def nextGeneration(def livingCells = []) {
        def next = [] as Set
        livingCells.each { cell ->
            if (livingNeighbours(cell, livingCells) in [2, 3])
                next << cell
        }
        allNeighbours(livingCells).findAll { !(it in livingCells) }.each { cell ->
            if (livingNeighbours(cell, livingCells) == 3)
                next << cell
        }
        next
    }

    static def livingNeighbours(def cell, def livingCells) {
        def count = 0
        livingCells.each { candidate ->
            if (candidate != cell && Math.abs(candidate[0] - cell[0]) <= 1 && Math.abs(candidate[1] - cell[1]) <= 1)
                count++
        }
        count
    }

    static def allNeighbours(def cells) {
        def neighbours = [] as Set
        def deltas = [(-1..1), (-1..1)].combinations().findAll { it != [0, 0] }
        cells.each { cell ->
            deltas.each { delta ->
                neighbours << [cell[0] + delta[0], cell[1] + delta[1]]
            }
        }
        neighbours
    }

}
