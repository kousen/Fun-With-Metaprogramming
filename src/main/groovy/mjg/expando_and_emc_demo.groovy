package mjg

Expando e = new Expando()
assert 0 == e.properties.size()

e.name = 'Dolly'
e.speak = { "Hello, $name!" }
assert 2 == e.properties.size()
assert 'Hello, Dolly!' == e.speak()

class Empty {}
Empty.metaClass.name = 'Dolly'
Empty.metaClass.speak = { "Hello, $name!" }
Empty emp = new Empty()
assert 'Hello, Dolly!' == emp.speak()