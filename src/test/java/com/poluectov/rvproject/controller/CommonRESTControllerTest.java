package com.poluectov.rvproject.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CommonRESTControllerTest {
    /*@Mock
    private Function<IdentifiedEntity, EntityModel<IdentifiedEntity>> assembler;
    @Mock
    private CommonRestService<IdentifiedEntity, IdentifiedEntity, IdentifiedEntity> service;

    @InjectMocks
    private CommonRESTController<IdentifiedEntity, IdentifiedEntity, IdentifiedEntity> controller;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void all_ReturnsListOfEntities() {
        // Arrange
        List<IdentifiedEntity> entities = new ArrayList<>();
        entities.add(new IdentifiedEntity(BigInteger.ONE));
        entities.add(new IdentifiedEntity(BigInteger.TWO));

        when(service.all()).thenReturn(entities);

        List<EntityModel<IdentifiedEntity>> entityModels = entities.stream()
                .map(EntityModel::of)
                .toList();

        // Act
        ResponseEntity<?> response = (ResponseEntity) controller.all();

        // Assert
        assertEquals(200, response.getStatusCodeValue());
        verify(service, times(1)).all();
    }

    @Test
    void newEntity_CreatesNewEntity() {
        // Arrange
        IdentifiedEntity request = new IdentifiedEntity();
        when(service.create(request)).thenReturn(new IdentifiedEntity());
        when(assembler.apply(request)).thenReturn(EntityModel.of(new IdentifiedEntity()));

        // Act
        ResponseEntity<?> response = controller.newEntity(request);

        // Assert
        assertEquals(201, response.getStatusCodeValue());
        verify(service, times(1)).create(request);
    }

    @SneakyThrows
    @Test
    void one_ReturnsSingleEntity() {
        // Arrange
        BigInteger id = BigInteger.ONE;
        IdentifiedEntity serviceResponse = new IdentifiedEntity();
        EntityModel<IdentifiedEntity> entityModel = EntityModel.of(serviceResponse);
        when(service.one(id)).thenReturn(serviceResponse);

        when(assembler.apply(serviceResponse)).thenReturn(entityModel);
        when(entityModel.getRequiredLink(IanaLinkRelations.SELF)).thenReturn(Link.of("localhost"));

        // Act
        ResponseEntity<?> response = controller.one(id);

        // Assert
        assertEquals(200, response.getStatusCodeValue());
        verify(service, times(1)).one(id);
    }

    @Test
    void updateEntity_UpdatesEntity() {
        // Arrange
        BigInteger id = BigInteger.ONE;
        IdentifiedEntity request = new IdentifiedEntity();
        when(service.update(id, request)).thenReturn(new IdentifiedEntity());

        // Act
        ResponseEntity<?> response = controller.updateEntity(id, request);

        // Assert
        assertEquals(201, response.getStatusCodeValue());
        verify(service, times(1)).update(id, request);
    }

    @Test
    void deleteEntity_DeletesEntity() {
        // Arrange
        BigInteger id = BigInteger.ONE;

        // Act
        ResponseEntity<?> response = controller.deleteEntity(id);

        // Assert
        assertEquals(204, response.getStatusCodeValue());
        verify(service, times(1)).delete(id);
    }*/
}
