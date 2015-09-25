package ch1

import org.scalatest._
import ch1.CompositionAndIdentity._

class IdentitySpec extends FlatSpec with Matchers {
	"An identity function" should "always return its parameter" in {
		val idInt = id[Int]
		val idRange = id[Range]
		val fixtureInt = 5
		val fixtureRange = 1 to 5
		
		idInt(fixtureInt) should be (fixtureInt)
		idRange(fixtureRange) should be (fixtureRange)
	}
}

class CompositionSpec extends FlatSpec with Matchers {
	"A composition function" should "always compose functions with matching types" in {
		val f = (x: Int) => 1 to x
		val g = (x: Range) => x.foldLeft(0)(_+_)
		val gof = compose(f, g)
		val fog = compose(g, f)

		gof(5) should be (15)
		fog(1 to 5) should be (1 to 15)
	}

	it should "respect identity" in {
		val f = (x: Int) => 1 to x
		val idInt = id[Int]
		val idRange = id[Range]
		val idof = compose(f, idRange)
		val foid = compose(idInt, f)

		idof(5) should be (f(5))
		foid(5) should be (f(5))
	}
}