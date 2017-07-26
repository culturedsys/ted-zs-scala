import org.scalatest.FunSpec

/**
  * Tests for the ForestDistanceMatrix class
  */
class ForestDistanceMatrixSpec extends FunSpec {
  describe("ForestDistanceMatrix") {
    describe("0 dimensions") {
      it("can be created") {
        ForestDistanceMatrix(0 until 0, 0 until 0)
      }

      val matrix = ForestDistanceMatrix(0 until 0, 0 until 0)

      it("can have a value set at (-1, -1)") {
        matrix(-1, -1) = 100
      }

      it("can have the value retrieved at (-1, -1)") {
        assert(matrix(-1, -1) == 100)
      }
    }

    describe("0 to 10") {
      it("can be created") {
        ForestDistanceMatrix(0 to 10, 0 to 10)
      }

      val matrix = ForestDistanceMatrix(0 to 10, 0 to 10)

      it("can be set at 0") {
        matrix(0, 0) = 100
      }

      it("can be accessed at 0") {
        assert(matrix(0, 0) == 100)
      }

      it("can be set at 10") {
        matrix(10, 10) = 200
      }

      it("can be accessed at 10") {
        assert(matrix(10, 10) == 200)
      }

      it("can be set at -1") {
        matrix(-1, -1) = 300
      }

      it("can be accessed at -1") {
        assert(matrix(-1, -1) == 300)
      }

      it("does not give the same value for 0 as -1") {
        assert(matrix(-1, -1) != matrix(0, 0))
      }

      it("cannot be updated at 11") {
        intercept[ArrayIndexOutOfBoundsException] {
          matrix(11, 11) = 400
        }
      }

      it("cannot be accessed at 11") {
        intercept[ArrayIndexOutOfBoundsException] {
          matrix(11, 11)
        }
      }
    }

    describe("10 to 20") {
      it("can be created") {
        ForestDistanceMatrix(10 to 20, 10 to 20)
      }

      val matrix = ForestDistanceMatrix(10 to 20, 10 to 20)

      it("can be updated at 10") {
        matrix(10, 10) = 100
      }

      it("can be accessed at 10") {
        assert(matrix(10, 10) == 100)
      }

      it("can be updated at 20") {
        matrix(20, 20) = 200
      }

      it("can be accessed at 20") {
        assert(matrix(20, 20) == 200)
      }

      it("can be updated at 9 (one less than lower bound)") {
        matrix(9, 9) = 300
      }

      it("can be accessed at 9 (one less than lower bound)") {
        assert(matrix(9, 9) == 300)
      }

      it("cannot be updated at 8 (more than one less than lower bound)") {
        intercept[ArrayIndexOutOfBoundsException] {
          matrix(8, 8) = 400
        }
      }

      it("cannot be accessed at 8 (more than one less than lower bound)") {
        intercept[ArrayIndexOutOfBoundsException] {
          matrix(8, 8)
        }
      }
    }
  }

}
