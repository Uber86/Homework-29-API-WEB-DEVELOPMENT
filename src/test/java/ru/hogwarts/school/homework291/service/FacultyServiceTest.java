package ru.hogwarts.school.homework291.service;

class FacultyServiceTest {

    /*FacultyService service = new FacultyRepository();


    @BeforeEach
    void title(){
        var q = new Faculty("last1", "lsat1");
        var w = new Faculty("last2", "lsat2");
        var e = new Faculty("last3", "lsat3");
        service.create(q);
        service.create(w);
        service.create(e);
    }

    @Test
    void createTest() {
        var e = new Faculty("last4", "lsat4");
        service.create(e);
        assertNotNull(e);
    }

    @Test
    void getTest() {
        var e = new Faculty("last3", "lsat3");
        service.create(e);
        assertSame(service.get(4), e);
    }

    @Test
    void NoGetTest() {
        var e = new Faculty("last3", "lsat3");
        service.create(e);
        var a = new Faculty("last3", "lsat3");
        assertNotSame(service.get(4), a);
    }

    @Test
    void geteqTest() {
        var e = new Faculty("last2", "lsat2");
        assertEquals(service.get(2) , e );
    }

    @Test
    void getNull() {
        service.delete(2);
        assertNull(service.get(2));
    }

    @Test
    void getNoNull() {
        service.delete(3);
        assertNotNull(service.get(2));
    }


    @Test
    void nullUpdateTest() {
        var b = new Faculty("last3", "lsat2");
        var a = service.update(new Faculty("last3", "lsat2"));
        assertNull(service.update(new Faculty("last3", "lsat2")));
        assertNull(a);

    }

    /*@Test
    void colorTest() {
        var f = "lsat3";
        var a = service.findByNameOrColor(f);
        var b = service.get(3);
        assertThat(Objects.equals(a, b));
    }



    @Test
    void updateTest() {

        var b = new Faculty("last3", "lsat2");
        var a = new Faculty("last2", "lsat2");
        service.create(a);
        service.update(b);
        assertEquals(b,service.get(4));
        assertNotEquals(a,service.get(4));
    }

     */


}