package edu.agh.to.fixit;

import edu.agh.to.fixit.controller.AdministrationController;
import edu.agh.to.fixit.model.Choice;
import edu.agh.to.fixit.model.Item;
import edu.agh.to.fixit.service.ChoiceService;
import edu.agh.to.fixit.service.ItemService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class AdministrationControllerTest {

    @InjectMocks
    private AdministrationController administrationController;

    @Mock
    private ChoiceService choiceService;
    @Mock
    private ItemService itemService;

    @Before
    public void initialize(){
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void testCreateChoice(){

        Choice newChoice = new Choice();
        newChoice.setName("newChoice");


        doAnswer(invocation -> {
            Choice choice = (Choice) invocation.getArguments()[0];
            choice.setId(1L);
            return null;
        }).when(choiceService).saveChoice(newChoice);

        administrationController.createChoice(newChoice);
        verify(choiceService).saveChoice(newChoice);
        assertEquals(1L,newChoice.getId().longValue());

    }

    @Test
    public void testUpdateChoiceInvocation(){
        Choice choice = new Choice();
        administrationController.updateChoice(choice);
        verify(choiceService).updateChoice(choice);
    }

    @Test
    public void testDeleteChoice(){
        Choice choice = new Choice();
        administrationController.deleteChoice(choice);
        verify(choiceService).deleteChoice(choice);
    }

    @Test
    public void testGetChoice(){
        Choice choiceForReturn = new Choice();
        long choiceId = 1L;
        when(choiceService.getChoice(choiceId)).thenReturn(choiceForReturn);
        Choice returnedChoice = administrationController.getChoice(choiceId);
        verify(choiceService).getChoice(choiceId);
        assertThat(choiceForReturn,is(returnedChoice));
    }

    @Test
    public void testSaveItem(){
        Item item = new Item();
        doAnswer(invocation -> {
            ((Item)invocation.getArguments()[0]).setId(1);
            return null;
        }).when(itemService).saveItem(item);

        Item returnedItem = administrationController.createItem(item);
        assertThat(returnedItem.getId(),is(1));
    }

    @Test
    public void testUpdateItem(){
        Item item = new Item();
        administrationController.updateItem(item);
        verify(itemService).updateItem(item);
    }

    @Test
    public void testDeleteItem(){
        Item item = new Item();
        administrationController.deleteItem(item);
        verify(itemService).deleteItem(item);
    }

    @Test
    public void testGetItem(){
        Item itemForReturn = new Item();
        long itemId = 1L;
        when(itemService.getItem(itemId)).thenReturn(itemForReturn);
        Item returnedItem = administrationController.getItem(itemId);
        verify(itemService).getItem(itemId);
        assertThat(itemForReturn,is(returnedItem));
    }

}
