package org.loose.fis.sre.services;

//import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.*;
import org.loose.fis.sre.exceptions.UsernameAlreadyExistsException;
import org.loose.fis.sre.model.User;
import org.loose.fis.sre.services.UserService;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.testfx.assertions.api.Assertions.assertThat;

class userServiceTest {

    @Test
    @DisplayName("Database is initialized, and there are users")
    void testDatabaseIsInitializedAndUserIsPersisted() {
        UserService.initDatabase();
        assertThat(UserService.getAllUsers()).isNotNull();
        assertThat(UserService.getAllUsers()).isNotEmpty();

    }

    @Test
        @DisplayName("Database is initialized, and there are buyers")
        void testDatabaseIsInitializedAndBuyerIsPersisted() {
            CumparatorService.initDatabase();
            assertThat(CumparatorService.getAllBuyers()).isNotNull();
            assertThat(CumparatorService.getAllBuyers()).isNotEmpty();

        }

        @Test
            @DisplayName("Database is initialized, and there are sellers")
            void testDatabaseIsInitializedAndSellerIsPersisted() {
                VanzatorService.initDatabase();
                assertThat(VanzatorService.getAllSellers()).isNotNull();
                assertThat(VanzatorService.getAllSellers()).isNotEmpty();

            }

            @Test
                @DisplayName("Database is initialized, and there are cars")
                void testDatabaseIsInitializedAndCarIsPersisted() {
                    MasinaService.initDatabase();
                    assertThat(MasinaService.getAllCars()).isNotNull();
                    assertThat(MasinaService.getAllCars()).isNotEmpty();

                }

                @Test
                    @DisplayName("Database is initialized, and there are offers")
                    void testDatabaseIsInitializedAndOfferIsPersisted() {
                        OfertaService.initDatabase();
                        assertThat(OfertaService.getAllOffers()).isNotNull();
                        assertThat(OfertaService.getAllOffers()).isNotEmpty();
                    }

                    @Test
                    @DisplayName("Cumparatorul tgb exista")
                    void testCumparatorTesttgbExists_retrievelMethodWorks() {
                    //CumparatorService.initDatabase();
                    assertThat(CumparatorService.getCumparator("tgb").getNume().equals("tgb"));
                    }
}
/*mergi din configuratie si faci testele*/